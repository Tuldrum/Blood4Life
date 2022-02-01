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

/**
 * SendMessageRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-10-24T15:11:21.199Z[GMT]")
public class SendMessageRequest {
  public static final String SERIALIZED_NAME_CHAT_ID = "chatId";
  @SerializedName(SERIALIZED_NAME_CHAT_ID)
  private String chatId;

  public static final String SERIALIZED_NAME_PHONE = "phone";
  @SerializedName(SERIALIZED_NAME_PHONE)
  private Integer phone;

  public static final String SERIALIZED_NAME_BODY = "body";
  @SerializedName(SERIALIZED_NAME_BODY)
  private String body;


  public SendMessageRequest chatId(String chatId) {
    
    this.chatId = chatId;
    return this;
  }

   /**
   * **Required if phone is not set**  Chat ID from the message list. Examples: 17633123456@c.us for private messages and 17680561234-1479621234@g.us for the group. Used instead of the phone parameter.
   * @return chatId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Required if phone is not set**  Chat ID from the message list. Examples: 17633123456@c.us for private messages and 17680561234-1479621234@g.us for the group. Used instead of the phone parameter.")

  public String getChatId() {
    return chatId;
  }



  public void setChatId(String chatId) {
    this.chatId = chatId;
  }


  public SendMessageRequest phone(Integer phone) {
    
    this.phone = phone;
    return this;
  }

   /**
   * **Required if chatId is not set**  A phone number starting with the country code. You do not need to add your number.   USA example: 17472822486.
   * @return phone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "**Required if chatId is not set**  A phone number starting with the country code. You do not need to add your number.   USA example: 17472822486.")

  public Integer getPhone() {
    return phone;
  }



  public void setPhone(Integer phone) {
    this.phone = phone;
  }


  public SendMessageRequest body(String body) {
    
    this.body = body;
    return this;
  }

   /**
   * Message text, UTF-8 or UTF-16 string with emoji 🍏
   * @return body
  **/
  @ApiModelProperty(required = true, value = "Message text, UTF-8 or UTF-16 string with emoji 🍏")

  public String getBody() {
    return body;
  }



  public void setBody(String body) {
    this.body = body;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMessageRequest sendMessageRequest = (SendMessageRequest) o;
    return Objects.equals(this.chatId, sendMessageRequest.chatId) &&
        Objects.equals(this.phone, sendMessageRequest.phone) &&
        Objects.equals(this.body, sendMessageRequest.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chatId, phone, body);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMessageRequest {\n");
    sb.append("    chatId: ").append(toIndentedString(chatId)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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

