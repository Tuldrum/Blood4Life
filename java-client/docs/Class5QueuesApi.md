# Class5QueuesApi

All URIs are relative to *https://api.chat-api.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**clearActionsQueue**](Class5QueuesApi.md#clearActionsQueue) | **POST** /clearActionsQueue | Clear outbound actions queue.
[**clearMessagesQueue**](Class5QueuesApi.md#clearMessagesQueue) | **POST** /clearMessagesQueue | Clear outbound messages queue.
[**showActionsQueue**](Class5QueuesApi.md#showActionsQueue) | **GET** /showActionsQueue | Get outbound messages queue.
[**showMessagesQueue**](Class5QueuesApi.md#showMessagesQueue) | **GET** /showMessagesQueue | Get outbound messages queue.


<a name="clearActionsQueue"></a>
# **clearActionsQueue**
> ClearActionsQueueStatus clearActionsQueue()

Clear outbound actions queue.

This method is needed when you accidentally sent thousands of actions in a row.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class5QueuesApi;

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

    Class5QueuesApi apiInstance = new Class5QueuesApi(defaultClient);
    try {
      ClearActionsQueueStatus result = apiInstance.clearActionsQueue();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class5QueuesApi#clearActionsQueue");
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

[**ClearActionsQueueStatus**](ClearActionsQueueStatus.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

<a name="clearMessagesQueue"></a>
# **clearMessagesQueue**
> ClearMessagesQueueStatus clearMessagesQueue()

Clear outbound messages queue.

This method is needed when you accidentally sent thousands of messages in a row.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class5QueuesApi;

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

    Class5QueuesApi apiInstance = new Class5QueuesApi(defaultClient);
    try {
      ClearMessagesQueueStatus result = apiInstance.clearMessagesQueue();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class5QueuesApi#clearMessagesQueue");
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

[**ClearMessagesQueueStatus**](ClearMessagesQueueStatus.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

<a name="showActionsQueue"></a>
# **showActionsQueue**
> OutboundActions showActionsQueue()

Get outbound messages queue.

When you create an action, all actions are queued up. If an action is not executed, it remains in the queue and will be sent for execution in time. again. The action cannot be executed due to the status of the device connected to the account.  This method give the last 100 actions in the queue.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class5QueuesApi;

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

    Class5QueuesApi apiInstance = new Class5QueuesApi(defaultClient);
    try {
      OutboundActions result = apiInstance.showActionsQueue();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class5QueuesApi#showActionsQueue");
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

[**OutboundActions**](OutboundActions.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

<a name="showMessagesQueue"></a>
# **showMessagesQueue**
> OutboundMessages showMessagesQueue()

Get outbound messages queue.

When sending messages, all messages are in the queue. If the message is not sent, then it remains in the queue and in time it will be sent again. The message may not be sent due to the status of the device connected to the account.   This method give the last 100 messages in the queue.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class5QueuesApi;

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

    Class5QueuesApi apiInstance = new Class5QueuesApi(defaultClient);
    try {
      OutboundMessages result = apiInstance.showMessagesQueue();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class5QueuesApi#showMessagesQueue");
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

[**OutboundMessages**](OutboundMessages.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

