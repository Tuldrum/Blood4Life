

# OutboundAction

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | action id in queue |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | type of the action in queue |  [optional]
**lastTry** | **Integer** | Last try time to execute a action |  [optional]
**jsonData** | [**Object**](.md) | Additional action data |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
CREATE_GROUP | &quot;create group&quot;
ADD_GROUP_PARTICIPANT | &quot;add group participant&quot;
REMOVE_GROUP_PARTICIPANT | &quot;remove group participant&quot;
PROMOTE_GROUP_PARTICIPANT | &quot;promote group participant&quot;
DEMOTE_GROUP_PARTICIPANT | &quot;demote group participant&quot;
READ_CHAT | &quot;read chat&quot;



