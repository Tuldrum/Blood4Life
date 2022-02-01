

# SendPTTRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**chatId** | **String** | **Required if phone is not set**  Chat ID from the message list. Examples: 17633123456@c.us for private messages and 17680561234-1479621234@g.us for the group. Used instead of the phone parameter. |  [optional]
**phone** | **Integer** | **Required if chatId is not set**  A phone number starting with the country code. You do not need to add your number.   USA example: 17472822486. |  [optional]
**audio** | **String** | A link to an audio ogg-file in opus codec  Or base64 ogg-file in opus codec, for example *data:audio/ogg;base64,...* | 



