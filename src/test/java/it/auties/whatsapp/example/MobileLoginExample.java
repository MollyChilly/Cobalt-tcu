package it.auties.whatsapp.example;

import it.auties.whatsapp.api.Whatsapp;
import it.auties.whatsapp.model.companion.CompanionDevice;
import it.auties.whatsapp.model.info.MessageInfo;
import it.auties.whatsapp.model.jid.Jid;
import it.auties.whatsapp.model.message.model.MessageContainer;
import it.auties.whatsapp.model.mobile.PhoneNumber;
import it.auties.whatsapp.model.mobile.SixPartsKeys;

import java.net.URI;
import java.util.Scanner;
import java.util.UUID;

public class MobileLoginExample {

    public static void main(String[] args) {

//        Whatsapp.builder()
//                .webClient()
//                .newConnection(SixPartsKeys.of("4531864427,gJANtkGQE9RLycD/BMoNTObKR1rQpp9ayjmsWPJbXDA=,N9if8rZeZ60shXpqUkDnRwoCIl96+/M7f4HhSTyL9Kg=,neiwtGvB0djWd7xrOIWe3hHlseaAekaGx/EIzL6f0m8=,CJ6U0fZ+ItK/rjwXaEUObOCSqIM6wuTgHGpxjkFSwEY=,NDUzMTg2NDQyNyO64ouD4RfrSkAFlA3Keo2O"))
//                // .proxy(URI.create("http://username:password@host:port/")) Remember to set an HTTP proxy
//                .registered()
//                .orElseThrow()
//                .addNodeReceivedListener(incoming -> System.out.printf("Received node %s%n", incoming))
//                .addNodeSentListener(outgoing -> System.out.printf("Sent node %s%n", outgoing))
//                .addLoggedInListener(api -> System.out.println("Logged in"))
//                .connect() // If you get error 403 o 503 the account is banned
//                .waitForDisconnection();

//        Whatsapp.builder()
//                .webClient()
//                .newConnection(UUID.fromString("22b0b358-f3fa-4075-8589-da05f07c5cd6"))
//                // .proxy(URI.create("http://username:password@host:port/")) Remember to set an HTTP proxy
//                .registered()
//                .orElseThrow()
//                .addNodeReceivedListener(incoming -> System.out.printf("Received node %s%n", incoming))
//                .addNodeSentListener(outgoing -> System.out.printf("Sent node %s%n", outgoing))
//                .addLoggedInListener(api ->
//                        System.out.println("Logged in"))
//                .connect() // If you get error 403 o 503 the account is banned
//                .waitForDisconnection();
//

        Whatsapp apiWhats = Whatsapp.builder()
                .mobileClient()
                .newConnection(SixPartsKeys.of("639089588212,y84t2PlMtp2RCGaxErLme9DI5KP3YjIIu6Usu5IQhDc=,4J9+UL5ZbDYresn6/U525pagdZYu1eJjfL7B4gYvC2k=,wIx1AlDA4u6JL6Mf00ehPjDKvqKaSJw1D+ypCYipjBc=,UPnq2oYWVJbRrjY4yQGx1YfG960V3yIdeqxx2tgadks=,JXb++mCo5YjPgv04HgmVag=="))
//                 .proxy(URI.create("http://username:password@host:port/")) //Remember to set an HTTP proxy
                .device(CompanionDevice.ios(false)) // Make sure to select the correct account type(business or personal) or you'll get error 401
                .registered()
                .orElseThrow()
                .addNodeReceivedListener(incoming -> System.out.printf("Received node %s%n", incoming))
                .addNodeSentListener(outgoing -> System.out.printf("Sent node %s%n", outgoing))
                .addLoggedInListener(api -> System.out.println("Logged in"))
                .connect() // If you get error 403 o 503 the account is banned
                .waitForDisconnection();

//        Whatsapp whatsapp = Whatsapp.builder()
//                .mobileClient()
//                .newConnection(SixPartsKeys.of("639089588212,y84t2PlMtp2RCGaxErLme9DI5KP3YjIIu6Usu5IQhDc=,4J9+UL5ZbDYresn6/U525pagdZYu1eJjfL7B4gYvC2k=,wIx1AlDA4u6JL6Mf00ehPjDKvqKaSJw1D+ypCYipjBc=,UPnq2oYWVJbRrjY4yQGx1YfG960V3yIdeqxx2tgadks=,JXb++mCo5YjPgv04HgmVag=="))
//                // .proxy(URI.create("http://username:password@host:port/")) Remember to set an HTTP proxy
//                .device(CompanionDevice.ios(false)) // Make sure to select  thecorrect account type(business or personal) or you'll get error 401
//                .registered()
//                .orElseThrow()
//                .addNodeReceivedListener(incoming -> System.out.printf("Received node %s%n", incoming))
//                .addNodeSentListener(outgoing -> System.out.printf("Sent node %s%n", outgoing))
//                .addLoggedInListener(api -> {System.out.println("Logged in");
//                    MessageContainer message = MessageContainer.of("are you there?");
//                    PhoneNumber phone = PhoneNumber.ofNullable(8615212419421L);
//                    if (phone != null) {
//                        Jid jid = phone.toJid();
//
//
//                        System.out.printf("jid : " + api.hasWhatsapp(jid));
//                        MessageInfo messageInfo = api.sendMessage(jid, message);
//                        System.out.println("Message sent: " + messageInfo);
//
//
//                    }
//                }
//                )
//                .connect() // If you get error 403 o 503 the account is banned
//                .addDisconnectedListener(reason -> System.out.printf("Disconnected: %s%n", reason))
//                .waitForDisconnection();
//        apiWhats.store().contacts().forEach(contact -> {
//            System.out.println("Contact: " + contact);
//        });

    }
//    public static void main(String[] args) {
//        System.out.println("Enter the six parts segment: ");
//        var scanner = new Scanner(System.in);
//        var sixParts = scanner.nextLine().trim();
//        System.out.println("Select if the account is business or personal:\n(1) Business (2) Personal");
//        var business = switch (scanner.nextInt()) {
//            case 1 -> true;
//            case 2 -> false;
//            default -> throw new IllegalStateException("Unexpected value: " + scanner.nextInt());
//        };
//        Whatsapp.builder()
//                .mobileClient()
//                .newConnection(SixPartsKeys.of(sixParts))
//                // .proxy(URI.create("http://username:password@host:port/")) Remember to set an HTTP proxy
//                .device(CompanionDevice.ios(business)) // Make sure to select the correct account type(business or personal) or you'll get error 401
//                .registered()
//                .orElseThrow()
//                .addNodeReceivedListener(incoming -> System.out.printf("Received node %s%n", incoming))
//                .addNodeSentListener(outgoing -> System.out.printf("Sent node %s%n", outgoing))
//                .addLoggedInListener(api -> System.out.println("Logged in"))
//                .connect() // If you get error 403 o 503 the account is banned
//                .waitForDisconnection();
//    }
}
