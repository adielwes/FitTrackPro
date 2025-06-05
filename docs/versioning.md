# 📦 App Versioning with Git Tags

This project uses Git tag-based versioning in the format `vMAJOR.MINOR.PATCH`, following the [SemVer](https://semver.org/) standard.

## 🔢 How it works

Versioning is automatically derived from the latest Git tag in the repository.

- **versionName** is extracted directly from the Git tag (e.g., `v1.2.3` → `1.2.3`)
- **versionCode** is calculated using:

  versionCode = MAJOR * 10000 + MINOR * 100 + PATCH

Example:
- Tag: `v1.2.3`
- versionName: "1.2.3"
- versionCode: 10203

## 🛠️ How to create a new version

To release a new version:

### Option 1: Using Git Flow

1. Merge changes into `develop`
2. Create a release branch:
   git checkout -b release/1.3.0 develop
3. Finish the release (this will create the tag automatically):
   git flow release finish '1.3.0'

### Option 2: Manually using Git

1. Make sure you're on `main` or a release branch
2. Create and push the tag:
   git tag -a v1.3.0 -m "Version 1.3.0"
   git push origin v1.3.0

## ⚙️ Where is it implemented?

The versioning logic is located in:

buildSrc/src/main/groovy/Versioning.groovy

It is used in the `app/build.gradle` file:

versionCode Versioning.getVersionCode()
versionName Versioning.getVersionName()

## ✅ Benefits

- Fully integrated with Git Flow
- Clean and consistent versioning
- Easy integration with CI/CD pipelines
- Prevents manual versioning errors
- Transparent and traceable