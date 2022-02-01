# Class3ChatsApi

All URIs are relative to *https://api.chat-api.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addGroupParticipant**](Class3ChatsApi.md#addGroupParticipant) | **POST** /addGroupParticipant | Adding participant to a group
[**demoteGroupParticipant**](Class3ChatsApi.md#demoteGroupParticipant) | **POST** /demoteGroupParticipant | Demote group participant
[**getChats**](Class3ChatsApi.md#getChats) | **GET** /dialogs | Get the chat list.
[**group**](Class3ChatsApi.md#group) | **POST** /group | Creates a group and sends the message to the created group.
[**promoteGroupParticipant**](Class3ChatsApi.md#promoteGroupParticipant) | **POST** /promoteGroupParticipant | Make participant in the group an administrator
[**readChat**](Class3ChatsApi.md#readChat) | **POST** /readChat | Open chat for reading messages
[**removeGroupParticipant**](Class3ChatsApi.md#removeGroupParticipant) | **POST** /removeGroupParticipant | Remove participant from a group


<a name="addGroupParticipant"></a>
# **addGroupParticipant**
> GroupParticipantStatus addGroupParticipant(groupParticipantAction)

Adding participant to a group

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class3ChatsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.chat-api.com");
    
    // Configure API key authorization: instanceId
    ApiKeyAuth instanceId = (ApiKeyAuth) defaultClient.getAuthentication("instanceId");
    instanceId.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //instanceId.setApiKeyPrefix("Token");

    // Configure API key authorization: token
    ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
    token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //token.setApiKeyPrefix("Token");

    Class3ChatsApi apiInstance = new Class3ChatsApi(defaultClient);
    GroupParticipantAction groupParticipantAction = new GroupParticipantAction(); // GroupParticipantAction | 
    try {
      GroupParticipantStatus result = apiInstance.addGroupParticipant(groupParticipantAction);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class3ChatsApi#addGroupParticipant");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupParticipantAction** | [**GroupParticipantAction**](GroupParticipantAction.md)|  |

### Return type

[**GroupParticipantStatus**](GroupParticipantStatus.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

<a name="demoteGroupParticipant"></a>
# **demoteGroupParticipant**
> GroupParticipantStatus demoteGroupParticipant(groupParticipantAction)

Demote group participant

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class3ChatsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.chat-api.com");
    
    // Configure API key authorization: instanceId
    ApiKeyAuth instanceId = (ApiKeyAuth) defaultClient.getAuthentication("instanceId");
    instanceId.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //instanceId.setApiKeyPrefix("Token");

    // Configure API key authorization: token
    ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
    token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //token.setApiKeyPrefix("Token");

    Class3ChatsApi apiInstance = new Class3ChatsApi(defaultClient);
    GroupParticipantAction groupParticipantAction = new GroupParticipantAction(); // GroupParticipantAction | 
    try {
      GroupParticipantStatus result = apiInstance.demoteGroupParticipant(groupParticipantAction);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class3ChatsApi#demoteGroupParticipant");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupParticipantAction** | [**GroupParticipantAction**](GroupParticipantAction.md)|  |

### Return type

[**GroupParticipantStatus**](GroupParticipantStatus.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

<a name="getChats"></a>
# **getChats**
> Chats getChats()

Get the chat list.

The chat list includes avatars.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class3ChatsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.chat-api.com");
    
    // Configure API key authorization: instanceId
    ApiKeyAuth instanceId = (ApiKeyAuth) defaultClient.getAuthentication("instanceId");
    instanceId.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //instanceId.setApiKeyPrefix("Token");

    // Configure API key authorization: token
    ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
    token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //token.setApiKeyPrefix("Token");

    Class3ChatsApi apiInstance = new Class3ChatsApi(defaultClient);
    try {
      Chats result = apiInstance.getChats();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class3ChatsApi#getChats");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Chats**](Chats.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

<a name="group"></a>
# **group**
> CreateGroupStatus group(createGroupAction)

Creates a group and sends the message to the created group.

The group will be added to the queue for sending and sooner or later it will be created, even if the phone is disconnected from the Internet or the authorization is not passed.   2 Oct 2018 update: chatId parameter will be returned if group was created on your phone within 20 second.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class3ChatsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.chat-api.com");
    
    // Configure API key authorization: instanceId
    ApiKeyAuth instanceId = (ApiKeyAuth) defaultClient.getAuthentication("instanceId");
    instanceId.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //instanceId.setApiKeyPrefix("Token");

    // Configure API key authorization: token
    ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
    token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //token.setApiKeyPrefix("Token");

    Class3ChatsApi apiInstance = new Class3ChatsApi(defaultClient);
    CreateGroupAction createGroupAction = new CreateGroupAction(); // CreateGroupAction | 
    try {
      CreateGroupStatus result = apiInstance.group(createGroupAction);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class3ChatsApi#group");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createGroupAction** | [**CreateGroupAction**](CreateGroupAction.md)|  |

### Return type

[**CreateGroupStatus**](CreateGroupStatus.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

<a name="promoteGroupParticipant"></a>
# **promoteGroupParticipant**
> GroupParticipantStatus promoteGroupParticipant(groupParticipantAction)

Make participant in the group an administrator

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class3ChatsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.chat-api.com");
    
    // Configure API key authorization: instanceId
    ApiKeyAuth instanceId = (ApiKeyAuth) defaultClient.getAuthentication("instanceId");
    instanceId.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //instanceId.setApiKeyPrefix("Token");

    // Configure API key authorization: token
    ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
    token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //token.setApiKeyPrefix("Token");

    Class3ChatsApi apiInstance = new Class3ChatsApi(defaultClient);
    GroupParticipantAction groupParticipantAction = new GroupParticipantAction(); // GroupParticipantAction | 
    try {
      GroupParticipantStatus result = apiInstance.promoteGroupParticipant(groupParticipantAction);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class3ChatsApi#promoteGroupParticipant");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupParticipantAction** | [**GroupParticipantAction**](GroupParticipantAction.md)|  |

### Return type

[**GroupParticipantStatus**](GroupParticipantStatus.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

<a name="readChat"></a>
# **readChat**
> ReadChatStatus readChat(readChatAction)

Open chat for reading messages

Use this method to make users see their messages read.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class3ChatsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.chat-api.com");
    
    // Configure API key authorization: instanceId
    ApiKeyAuth instanceId = (ApiKeyAuth) defaultClient.getAuthentication("instanceId");
    instanceId.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //instanceId.setApiKeyPrefix("Token");

    // Configure API key authorization: token
    ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
    token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //token.setApiKeyPrefix("Token");

    Class3ChatsApi apiInstance = new Class3ChatsApi(defaultClient);
    ReadChatAction readChatAction = new ReadChatAction(); // ReadChatAction | 
    try {
      ReadChatStatus result = apiInstance.readChat(readChatAction);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class3ChatsApi#readChat");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **readChatAction** | [**ReadChatAction**](ReadChatAction.md)|  |

### Return type

[**ReadChatStatus**](ReadChatStatus.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

<a name="removeGroupParticipant"></a>
# **removeGroupParticipant**
> GroupParticipantStatus removeGroupParticipant(groupParticipantAction)

Remove participant from a group

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class3ChatsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.chat-api.com");
    
    // Configure API key authorization: instanceId
    ApiKeyAuth instanceId = (ApiKeyAuth) defaultClient.getAuthentication("instanceId");
    instanceId.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //instanceId.setApiKeyPrefix("Token");

    // Configure API key authorization: token
    ApiKeyAuth token = (ApiKeyAuth) defaultClient.getAuthentication("token");
    token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //token.setApiKeyPrefix("Token");

    Class3ChatsApi apiInstance = new Class3ChatsApi(defaultClient);
    GroupParticipantAction groupParticipantAction = new GroupParticipantAction(); // GroupParticipantAction | 
    try {
      GroupParticipantStatus result = apiInstance.removeGroupParticipant(groupParticipantAction);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class3ChatsApi#removeGroupParticipant");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupParticipantAction** | [**GroupParticipantAction**](GroupParticipantAction.md)|  |

### Return type

[**GroupParticipantStatus**](GroupParticipantStatus.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

