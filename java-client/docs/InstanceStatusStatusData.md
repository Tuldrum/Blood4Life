

# InstanceStatusStatusData

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**substatus** | [**SubstatusEnum**](#SubstatusEnum) | Instance Substatus |  [optional]
**title** | **String** | Status title in the language of the instance |  [optional]
**msg** | **String** | Status message in the language of the instance |  [optional]
**submsg** | **String** | Additional status message in the language of the instance |  [optional]
**actions** | [**InstanceStatusStatusDataActions**](InstanceStatusStatusDataActions.md) |  |  [optional]
**reason** | [**ReasonEnum**](#ReasonEnum) | The reason why the instance is in \&quot;loading\&quot; status |  [optional]



## Enum: SubstatusEnum

Name | Value
---- | -----
NORMAL | &quot;normal&quot;
LOADING | &quot;loading&quot;
OFFLINE | &quot;offline&quot;
EXPIRED | &quot;expired&quot;
OPENING | &quot;opening&quot;
PAIRING | &quot;pairing&quot;
TIMEOUT | &quot;timeout&quot;
COMPUTER | &quot;computer&quot;
PHONE | &quot;phone&quot;
BATTERY_LOW_1 | &quot;battery_low_1&quot;
BATTERY_LOW_2 | &quot;battery_low_2&quot;



## Enum: ReasonEnum

Name | Value
---- | -----
CONNECTING | &quot;connecting&quot;
SYNCING | &quot;syncing&quot;
OFFLINE | &quot;offline&quot;
PROXYBLOCK | &quot;proxyblock&quot;
CONFLICT | &quot;conflict&quot;



