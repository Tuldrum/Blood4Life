

# InstanceStatus

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountStatus** | [**AccountStatusEnum**](#AccountStatusEnum) | Instance Status |  [optional]
**qrCode** | **byte[]** | Base64-encoded contents of the QR code |  [optional]
**statusData** | [**InstanceStatusStatusData**](InstanceStatusStatusData.md) |  |  [optional]



## Enum: AccountStatusEnum

Name | Value
---- | -----
GOT_QR_CODE | &quot;got qr code&quot;
AUTHENTICATED | &quot;authenticated&quot;
LOADING | &quot;loading&quot;
INIT | &quot;init&quot;
NOT_PAID | &quot;not_paid&quot;



