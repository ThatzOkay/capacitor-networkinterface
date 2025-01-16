# capacitor-networkinterface

a

## Install

```bash
npm install capacitor-networkinterface
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`getWiFiIPAddress()`](#getwifiipaddress)
* [`requestPermission()`](#requestpermission)
* [`checkPermissions()`](#checkpermissions)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### getWiFiIPAddress()

```typescript
getWiFiIPAddress() => Promise<{ value: string; }>
```

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### requestPermission()

```typescript
requestPermission() => Promise<{ receive: string; }>
```

**Returns:** <code>Promise&lt;{ receive: string; }&gt;</code>

--------------------


### checkPermissions()

```typescript
checkPermissions() => Promise<{ status: string; }>
```

**Returns:** <code>Promise&lt;{ status: string; }&gt;</code>

--------------------

</docgen-api>
