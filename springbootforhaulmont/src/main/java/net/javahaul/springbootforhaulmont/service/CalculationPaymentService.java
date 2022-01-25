package net.javahaul.springbootforhaulmont.service;

import net.javahaul.springbootforhaulmont.model.OfferCredit;
import net.javahaul.springbootforhaulmont.model.ScheduleOfPayment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Component
public class CalculationPaymentService {
    private final OfferCreditServiceInterface offerCreditInterface;
    private final SchedulePaymentServiceInterface schedulePaymentServiceInterface;

    public CalculationPaymentService(OfferCreditServiceInterface offerCreditInterface, SchedulePaymentServiceInterface schedulePaymentServiceInterface, EntityManager entityManager) {
        this.offerCreditInterface = offerCreditInterface;
        this.schedulePaymentServiceInterface = schedulePaymentServiceInterface;
        this.entityManager = entityManager;
    }

    private final EntityManager entityManager;


    public void collectDataAboutOfferOfCredit(OfferCredit offerCredit) {
        if (offerCredit.getId() != null) {
            offerCredit = mergeAndClearPaymentScheduleList(offerCredit);
        }
        BigDecimal firstPay = offerCredit.getFirstPayment() != null
                ? offerCredit.getFirstPayment()
                : BigDecimal.ZERO;
        BigDecimal remainingCreditAmount = offerCredit.getSum().subtract(firstPay);
        BigDecimal monthlyPaymentToBodyCredit = remainingCreditAmount
                .divide(BigDecimal.valueOf(offerCredit.getCreditTerm()), 2, RoundingMode.HALF_EVEN);
        BigDecimal interestRatePerMonth = offerCredit.getCredit().getCreditPercentage()
                .divide(BigDecimal.valueOf(12), 4, RoundingMode.HALF_EVEN);
        BigDecimal monthlyPaymentToPercentCredit = remainingCreditAmount.multiply(interestRatePerMonth)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN);
        calculateAndCreatePaymentSchedules(remainingCreditAmount, monthlyPaymentToBodyCredit,
                monthlyPaymentToPercentCredit, offerCredit);
    }

    private void calculateAndCreatePaymentSchedules(BigDecimal remainingCreditAmount,
                                                    BigDecimal monthlyPaymentToBodyCredit,
                                                    BigDecimal monthlyPaymentToPercentCredit,
                                                    OfferCredit offerOfCredit) {
        Integer periodInMonths = offerOfCredit.getCreditTerm();
        BigDecimal monthPay, percentSum = BigDecimal.ZERO;
        List<ScheduleOfPayment> paymentScheduleList = new ArrayList<>(periodInMonths);
        for (int i = 0; i < periodInMonths; i++) {
            monthPay = monthlyPaymentToBodyCredit.add(monthlyPaymentToPercentCredit);
            percentSum = percentSum.add(monthlyPaymentToPercentCredit);
            remainingCreditAmount = remainingCreditAmount.subtract(monthlyPaymentToBodyCredit);
            paymentScheduleList.add(
                    ScheduleOfPayment.builder()
                            .amountPayment(monthPay)
                            .datePayment(LocalDate.now().plusMonths(i + 1))
                            .amountPaymentPerBody(monthlyPaymentToBodyCredit)
                            .amountRepaymentPercent(monthlyPaymentToPercentCredit)
                            .balance(remainingCreditAmount.compareTo(BigDecimal.ZERO) > 0
                                    ? remainingCreditAmount
                                    : BigDecimal.ZERO)
                            .offerOfCredit(offerOfCredit)
                            .build()
            );
        }
        offerOfCredit.setSumPercent(percentSum);
        saveAll(offerOfCredit, paymentScheduleList);
    }

    private void saveAll(OfferCredit offerOfCredit, List<ScheduleOfPayment> paymentScheduleList) {
        offerCreditInterface.saveOfferCredit(offerOfCredit);
        schedulePaymentServiceInterface.saveAllScheduleOfPayment(paymentScheduleList);
    }

    private OfferCredit mergeAndClearPaymentScheduleList(OfferCredit offerOfCredit) {
        offerOfCredit = entityManager.merge(offerOfCredit);
        schedulePaymentServiceInterface.deleteAllByCreditOfferId(offerOfCredit.getId());
        return offerOfCredit;
    }
}


