

# SendLinkRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**chatId** | **String** | **Required if phone is not set**  Chat ID from the message list. Examples: 17633123456@c.us for private messages and 17680561234-1479621234@g.us for the group. Used instead of the phone parameter. |  [optional]
**phone** | **Integer** | **Required if chatId is not set**  A phone number starting with the country code. You do not need to add your number.   USA example: 17472822486. |  [optional]
**body** | **String** | HTTP or HTTPS link, for example *https://wikimedia.org* | 
**previewBase64** | **String** | Base64-encoded file with mime data, for example *data:image/jpeg;base64,/9j/4AAQSkZJRgABAQ...* for link&#39;s preview | 
**title** | **String** | Title for send link | 
**description** | **String** | Description for send link |  [optional]



