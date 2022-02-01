# Class7TestingApi

All URIs are relative to *https://api.chat-api.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**instanceStatuses**](Class7TestingApi.md#instanceStatuses) | **GET** /instanceStatuses | Returns instance status changes history.
[**webhookStatuses**](Class7TestingApi.md#webhookStatuses) | **GET** /webhookStatus | Returns webhook status for message.


<a name="instanceStatuses"></a>
# **instanceStatuses**
> Statuses instanceStatuses(minTime, maxTime)

Returns instance status changes history.

Requires enable \&quot;instanceStatuses\&quot; option for collecting data.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class7TestingApi;

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

    Class7TestingApi apiInstance = new Class7TestingApi(defaultClient);
    Integer minTime = 946684800; // Integer | Filter statuses received after specified date. Example: 946684800.
    Integer maxTime = 946684800; // Integer | Filter statuses received before specified date. Example: 946684800.
    try {
      Statuses result = apiInstance.instanceStatuses(minTime, maxTime);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class7TestingApi#instanceStatuses");
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
 **minTime** | **Integer**| Filter statuses received after specified date. Example: 946684800. | [optional]
 **maxTime** | **Integer**| Filter statuses received before specified date. Example: 946684800. | [optional]

### Return type

[**Statuses**](Statuses.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

<a name="webhookStatuses"></a>
# **webhookStatuses**
> WebhookStatus webhookStatuses(msgId)

Returns webhook status for message.

Requires enable \&quot;webhookStatuses\&quot; option for collecting data.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.Class7TestingApi;

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

    Class7TestingApi apiInstance = new Class7TestingApi(defaultClient);
    String msgId = false_17472822486@c.us_DF38E6A25B42CC8CCE57EC40F; // String | Message ID. Example: false_17472822486@c.us_DF38E6A25B42CC8CCE57EC40F.
    try {
      WebhookStatus result = apiInstance.webhookStatuses(msgId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling Class7TestingApi#webhookStatuses");
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
 **msgId** | **String**| Message ID. Example: false_17472822486@c.us_DF38E6A25B42CC8CCE57EC40F. |

### Return type

[**WebhookStatus**](WebhookStatus.md)

### Authorization

[instanceId](../README.md#instanceId), [token](../README.md#token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server response example |  -  |

