package net.javahaul.springbootforhaulmont.controller;

import net.javahaul.springbootforhaulmont.model.ScheduleOfPayment;
import net.javahaul.springbootforhaulmont.service.SchedulePaymentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/payment_schedules")
public class SchedulePaymentController {

    public SchedulePaymentServiceInterface schedulePaymentServiceInterface;

    @Autowired
    public SchedulePaymentController(SchedulePaymentServiceInterface schedulePaymentServiceInterface) {
        this.schedulePaymentServiceInterface = schedulePaymentServiceInterface;
    }

    @GetMapping("/payment_schedules_list/{offerOfCreditId}")
    public String homePage(@PathVariable("offerOfCreditId") UUID offerOfCreditId, Model model) {
        model.addAttribute("listPaymentSchedules", schedulePaymentServiceInterface.findByOfferOfCreditId(offerOfCreditId));
        return "/bank/schedulePayment/scheduleOfPayment-list";
    }

    @PostMapping("/save_payment_schedule")
    public String saveScheduleOfPayment(@ModelAttribute("schedulePayment") @Valid ScheduleOfPayment schedulePayment,
                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/bank/schedulePayment/scheduleOfPayment-update";
        }
        UUID offerOfCreditId = schedulePayment.getOfferOfCredit().getId();
        schedulePaymentServiceInterface.saveScheduleOfPayment(schedulePayment);
        return String.format("redirect:/payment_schedules/payment_schedules_list/%s", offerOfCreditId);
    }

    @GetMapping("/show_form_for_update/{paymentScheduleId}")
    public String formForUpdate(@PathVariable("paymentScheduleId") UUID paymentScheduleId, Model model) {
        model.addAttribute("paymentSchedule", schedulePaymentServiceInterface.findScheduleOfPaymentById(paymentScheduleId));
        return "bank/schedulePayment/scheduleOfPayment-update";
    }

    @GetMapping("/delete_payment_schedule/{paymentScheduleId}")
    public String deleteScheduleOfPayment(@PathVariable("paymentScheduleId") UUID paymentScheduleId) {
        UUID offerOfCreditId = schedulePaymentServiceInterface.findScheduleOfPaymentById(paymentScheduleId).getOfferOfCredit().getId();
        schedulePaymentServiceInterface.deleteScheduleOfPaymentById(paymentScheduleId);
        return String.format("redirect:/payment_schedules/payment_schedules_list/%s", offerOfCreditId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onException() {
        return "Wrong page number";
    }
}



