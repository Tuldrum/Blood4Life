

# ForwardMessageRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**chatId** | **String** | **Required if phone is not set**  Chat ID from the message list. Examples: 17633123456@c.us for private messages and 17680561234-1479621234@g.us for the group. Used instead of the phone parameter. |  [optional]
**phone** | **Integer** | **Required if chatId is not set**  A phone number starting with the country code. You do not need to add your number.   USA example: 17472822486. |  [optional]
**messageId** | **String** | Message ID | Message IDs array. Example: \&quot;false_6590996758@c.us_3EB03104D2B84CEAD82F\&quot; or [\&quot;false_6590996758@c.us_3EB03104D2B84CEAD82F\&quot;, \&quot;false_6590996758@c.us_3EB03104D2B84CEAD82G\&quot;] | 



