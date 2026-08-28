import 'package:photo_manager/photo_manager.dart';

const _galleryPermissionOption = PermissionRequestOption(
  iosAccessLevel: IosAccessLevel.readWrite,
);

Future<bool> hasGalleryAccess() async {
  final permissionState = await PhotoManager.getPermissionState(
    requestOption: _galleryPermissionOption,
  );
  return permissionState.hasAccess;
}

Future<bool> requestGalleryAccess() async {
  final permissionState = await PhotoManager.requestPermissionExtend(
    requestOption: _galleryPermissionOption,
  );
  return permissionState.hasAccess;
}
