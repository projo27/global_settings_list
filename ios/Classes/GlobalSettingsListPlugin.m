#import "GlobalSettingsListPlugin.h"
#if __has_include(<global_settings_list/global_settings_list-Swift.h>)
#import <global_settings_list/global_settings_list-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "global_settings_list-Swift.h"
#endif

@implementation GlobalSettingsListPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftGlobalSettingsListPlugin registerWithRegistrar:registrar];
}
@end
