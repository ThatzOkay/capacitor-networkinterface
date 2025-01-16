// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorNetworkinterface",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorNetworkinterface",
            targets: ["CapacitorNetworkInterfacePlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "CapacitorNetworkInterfacePlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/CapacitorNetworkInterfacePlugin"),
        .testTarget(
            name: "CapacitorNetworkInterfacePluginTests",
            dependencies: ["CapacitorNetworkInterfacePlugin"],
            path: "ios/Tests/CapacitorNetworkInterfacePluginTests")
    ]
)