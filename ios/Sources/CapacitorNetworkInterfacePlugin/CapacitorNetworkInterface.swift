import Foundation

@objc public class CapacitorNetworkInterface: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
