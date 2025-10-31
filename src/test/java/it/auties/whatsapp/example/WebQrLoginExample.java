package it.auties.whatsapp.example;

import it.auties.whatsapp.api.Whatsapp;
import it.auties.whatsapp.api.WhatsappVerificationHandler;
import it.auties.whatsapp.api.WhatsappWebHistoryPolicy;
import it.auties.whatsapp.model.info.ChatMessageInfo;
import it.auties.whatsapp.model.jid.Jid;
import it.auties.whatsapp.model.message.model.MessageContainer;
import it.auties.whatsapp.model.mobile.PhoneNumber;

public class WebQrLoginExample {
    public static void main(String[] args) {
        Whatsapp apiWhats = Whatsapp.builder()
                .webClient()
                .lastConnection()
                .registered()
                .orElseThrow()
//                .historySetting(WhatsappWebHistoryPolicy.standard(true))
//                .unregistered(WhatsappVerificationHandler.Web.QrCode.toTerminal())
                .addLoggedInListener(api ->
                        {
                            System.out.println("Logged in");
                            MessageContainer message = MessageContainer.of("are you there?");
                            PhoneNumber phone = PhoneNumber.ofNullable(639089588212L);
                            if (phone != null) {
                                Jid jid = phone.toJid();


                                System.out.printf("jid : " + api.hasWhatsapp(jid));
                                api.sendMessage(jid, message);

                            }

                        }
                )
//                .addWebAppPrimaryFeaturesListener(features -> System.out.printf("Received features: %s%n", features))
                .addNewMessageListener((api, message) -> System.out.println(message))
                .addContactsListener((api, contacts) -> System.out.printf("Contacts: %s%n", contacts.size()))
                .addChatsListener((api, chats) -> System.out.printf("Chats: %s%n", chats.size()))
                .addNewslettersListener((api, newsletters) -> System.out.printf("Newsletters: %s%n", newsletters.size()))
                .addNodeReceivedListener(incoming -> System.out.printf("Received node %s%n", incoming))
                .addNodeSentListener(outgoing -> System.out.printf("Sent node %s%n", outgoing))
                .addWebAppStateActionListener((action, info) -> System.out.printf("New action: %s, info: %s%n", action, info))
                .addWebAppStateSettingListener(setting -> System.out.printf("New setting: %s%n", setting))
                .addMessageStatusListener((info) -> System.out.printf("Message status update for %s%n", info.id()))
                .addWebHistorySyncMessagesListener((api, chat, last) -> System.out.printf("%s now has %s messages: %s(oldest message: %s)%n", chat.name(), chat.messages().size(), !last ? "waiting for more" : "done", chat.oldestMessage().flatMap(ChatMessageInfo::timestamp).orElse(null)))
                .addDisconnectedListener(reason -> System.out.printf("Disconnected: %s%n", reason))
                .connect()
                .waitForDisconnection();
        MessageContainer message = MessageContainer.of("are you there?");
        PhoneNumber phone = PhoneNumber.ofNullable(8615212419421L);
        if (phone != null) {
            Jid jid = phone.toJid();


            System.out.printf("jid : " + apiWhats.hasWhatsapp(jid));
            apiWhats.sendMessage(jid, message);

        }
//
//        apiWhats.waitForDisconnection();
//        apiWhats.disconnect();
    }
}
