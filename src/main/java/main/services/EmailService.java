package main.services;

import org.springframework.mail.SimpleMailMessage;

import main.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

}
