

# SendContactRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**chatId** | **String** | **Required if phone is not set**  Chat ID from the message list. Examples: 17633123456@c.us for private messages and 17680561234-1479621234@g.us for the group. Used instead of the phone parameter. |  [optional]
**phone** | **Integer** | **Required if chatId is not set**  A phone number starting with the country code. You do not need to add your number.   USA example: 17472822486. |  [optional]
**contactId** | **String** | Contact ID | Contact IDs array. Example: \&quot;17633123456@c.us\&quot; or [\&quot;17633123456@c.us\&quot;, \&quot;17633123457@c.us\&quot;] | 



