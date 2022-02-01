

# OutboundMessage

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | message id in queue |  [optional]
**body** | **String** | text message in queue |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | type of the message in queue |  [optional]
**lastTry** | **Integer** | Last try time to send a message |  [optional]
**metadata** | [**Object**](.md) | Additional message data |  [optional]



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



