/*
 * Chat API SDK
 * The SDK allows you to receive and send messages through your WhatsApp account. [Sign up now](https://app.chat-api.com/)  The Chat API is based on the WhatsApp WEB protocol and excludes the ban both when using libraries from mgp25 and the like. Despite this, your account can be banned by anti-spam system WhatsApp after several clicking the \"block\" button.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: sale@chat-api.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.Chats;
import org.openapitools.client.model.CreateGroupAction;
import org.openapitools.client.model.CreateGroupStatus;
import org.openapitools.client.model.GroupParticipantAction;
import org.openapitools.client.model.GroupParticipantStatus;
import org.openapitools.client.model.ReadChatAction;
import org.openapitools.client.model.ReadChatStatus;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for Class3ChatsApi
 */
@Ignore
public class Class3ChatsApiTest {

    private final Class3ChatsApi api = new Class3ChatsApi();

    
    /**
     * Adding participant to a group
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addGroupParticipantTest() throws ApiException {
        GroupParticipantAction groupParticipantAction = null;
        GroupParticipantStatus response = api.addGroupParticipant(groupParticipantAction);

        // TODO: test validations
    }
    
    /**
     * Demote group participant
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void demoteGroupParticipantTest() throws ApiException {
        GroupParticipantAction groupParticipantAction = null;
        GroupParticipantStatus response = api.demoteGroupParticipant(groupParticipantAction);

        // TODO: test validations
    }
    
    /**
     * Get the chat list.
     *
     * The chat list includes avatars.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getChatsTest() throws ApiException {
        Chats response = api.getChats();

        // TODO: test validations
    }
    
    /**
     * Creates a group and sends the message to the created group.
     *
     * The group will be added to the queue for sending and sooner or later it will be created, even if the phone is disconnected from the Internet or the authorization is not passed.   2 Oct 2018 update: chatId parameter will be returned if group was created on your phone within 20 second.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void groupTest() throws ApiException {
        CreateGroupAction createGroupAction = null;
        CreateGroupStatus response = api.group(createGroupAction);

        // TODO: test validations
    }
    
    /**
     * Make participant in the group an administrator
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void promoteGroupParticipantTest() throws ApiException {
        GroupParticipantAction groupParticipantAction = null;
        GroupParticipantStatus response = api.promoteGroupParticipant(groupParticipantAction);

        // TODO: test validations
    }
    
    /**
     * Open chat for reading messages
     *
     * Use this method to make users see their messages read.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void readChatTest() throws ApiException {
        ReadChatAction readChatAction = null;
        ReadChatStatus response = api.readChat(readChatAction);

        // TODO: test validations
    }
    
    /**
     * Remove participant from a group
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void removeGroupParticipantTest() throws ApiException {
        GroupParticipantAction groupParticipantAction = null;
        GroupParticipantStatus response = api.removeGroupParticipant(groupParticipantAction);

        // TODO: test validations
    }
    
}
