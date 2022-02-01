

# Message

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | unique id |  [optional]
**body** | **String** | text message for type \&quot;chat\&quot;, or link to download the file for \&quot;ptt\&quot;, \&quot;image\&quot;, \&quot;audio\&quot;, \&quot;video\&quot; and \&quot;document\&quot;, or latitude and longitude for \&quot;location\&quot;, or message \&quot;[Call]\&quot; for \&quot;call_log\&quot; |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | type of the message |  [optional]
**senderName** | **String** | Sender name |  [optional]
**fromMe** | **Boolean** | true - outgoing, false - incoming |  [optional]
**author** | **String** | Author ID of the message, useful for groups |  [optional]
**time** | **Integer** | send time, unix timestamp |  [optional]
**chatId** | **String** | chat ID |  [optional]
**messageNumber** | **Integer** | sequence number of the message in the database |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
CHAT | &quot;chat&quot;
IMAGE | &quot;image&quot;
PTT | &quot;ptt&quot;
DOCUMENT | &quot;document&quot;
AUDIO | &quot;audio&quot;
VIDEO | &quot;video&quot;
LOCATION | &quot;location&quot;
CALL_LOG | &quot;call_log&quot;



