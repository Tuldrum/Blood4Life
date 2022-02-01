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


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CreateGroupAction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-10-24T15:11:21.199Z[GMT]")
public class CreateGroupAction {
  public static final String SERIALIZED_NAME_GROUP_NAME = "groupName";
  @SerializedName(SERIALIZED_NAME_GROUP_NAME)
  private String groupName;

  public static final String SERIALIZED_NAME_CHAT_IDS = "chatIds";
  @SerializedName(SERIALIZED_NAME_CHAT_IDS)
  private List<String> chatIds = null;

  public static final String SERIALIZED_NAME_PHONES = "phones";
  @SerializedName(SERIALIZED_NAME_PHONES)
  private List<Integer> phones = null;

  public static final String SERIALIZED_NAME_MESSAGE_TEXT = "messageText";
  @SerializedName(SERIALIZED_NAME_MESSAGE_TEXT)
  private String messageText;


  public CreateGroupAction groupName(String groupName) {
    
    this.groupName = groupName;
    return this;
  }

   /**
   * Name of the group being created
   * @return groupName
  **/
  @ApiModelProperty(example = "New group", required = true, value = "Name of the group being created")

  public String getGroupName() {
    return groupName;
  }



  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }


  public CreateGroupAction chatIds(List<String> chatIds) {
    
    this.chatIds = chatIds;
    return this;
  }

  public CreateGroupAction addChatIdsItem(String chatIdsItem) {
    if (this.chatIds == null) {
      this.chatIds = new ArrayList<String>();
    }
    this.chatIds.add(chatIdsItem);
    return this;
  }

   /**
   * **Required if phones is not set**  An array of new participients chatIds. 
   * @return chatIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Required if phones is not set**  An array of new participients chatIds. ")

  public List<String> getChatIds() {
    return chatIds;
  }



  public void setChatIds(List<String> chatIds) {
    this.chatIds = chatIds;
  }


  public CreateGroupAction phones(List<Integer> phones) {
    
    this.phones = phones;
    return this;
  }

  public CreateGroupAction addPhonesItem(Integer phonesItem) {
    if (this.phones == null) {
      this.phones = new ArrayList<Integer>();
    }
    this.phones.add(phonesItem);
    return this;
  }

   /**
   * **Required if chatIds is not set**  An array of phones starting with the country code. You do not need to add your number.   USA example: [17472822486&#39;].
   * @return phones
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Required if chatIds is not set**  An array of phones starting with the country code. You do not need to add your number.   USA example: [17472822486'].")

  public List<Integer> getPhones() {
    return phones;
  }



  public void setPhones(List<Integer> phones) {
    this.phones = phones;
  }


  public CreateGroupAction messageText(String messageText) {
    
    this.messageText = messageText;
    return this;
  }

   /**
   * The text of the message that will be sent to the group when it is created. If you do not set a parameter, the message will not be sent
   * @return messageText
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Group created!", value = "The text of the message that will be sent to the group when it is created. If you do not set a parameter, the message will not be sent")

  public String getMessageText() {
    return messageText;
  }



  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateGroupAction createGroupAction = (CreateGroupAction) o;
    return Objects.equals(this.groupName, createGroupAction.groupName) &&
        Objects.equals(this.chatIds, createGroupAction.chatIds) &&
        Objects.equals(this.phones, createGroupAction.phones) &&
        Objects.equals(this.messageText, createGroupAction.messageText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupName, chatIds, phones, messageText);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateGroupAction {\n");
    sb.append("    groupName: ").append(toIndentedString(groupName)).append("\n");
    sb.append("    chatIds: ").append(toIndentedString(chatIds)).append("\n");
    sb.append("    phones: ").append(toIndentedString(phones)).append("\n");
    sb.append("    messageText: ").append(toIndentedString(messageText)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

