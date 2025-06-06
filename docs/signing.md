# 🔐 Release Signing Guide for FitTrackPro

This project requires signing to build the release APK or AAB.

To allow developers to generate their own signed builds without using the official keystore,
follow the steps below to generate a local keystore and configure the required environment variables.

---

## 🧱 1. Generate your own keystore

Open your terminal and run:

```
keytool -genkeypair \
  -v \
  -keystore keystore.jks \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000 \
  -alias keystore_alias
```

You will be prompted to enter:
- A keystore password
- A key alias (e.g., `keystore_alias`)
- Key password
- Personal/organizational info

This will generate a `keystore.jks` file in your current directory.

---

## ⚙️ 2. Set environment variables

To enable the release build, set the following environment variables in your shell session:

```
export KEYSTORE_FILE=/full/path/to/keystore.jks
export SIGNING_KEY_ALIAS=keystore_alias
export SIGNING_KEY_PASSWORD=yourKeyPassword
export SIGNING_STORE_PASSWORD=yourKeystorePassword
```

Tip: You can also add these lines to your `~/.bashrc`, `~/.zshrc`, or `~/.profile` to make them persistent.

---

## 🔨 3. Build the signed release

Once the environment variables are set, run one of the following commands to build the release version:

```
./gradlew bundleRelease
```

or

```
./gradlew assembleRelease
```

This will generate a signed AAB or APK in your `app/build/outputs/` directory.

---

## 🧪 Tip: Verify your keystore

To check the contents of your keystore and confirm it was created properly:

```
keytool -list -v -keystore keystore.jks
```

---

## ⚠️ Integration in build.gradle

The signing configuration in `app/build.gradle` should look like this:

````groovy
signingConfigs {
    release {
        storeFile file(System.getenv("KEYSTORE_FILE") ?: "keystore.jks")
        storePassword System.getenv("SIGNING_STORE_PASSWORD")
        keyAlias System.getenv("SIGNING_KEY_ALIAS")
        keyPassword System.getenv("SIGNING_KEY_PASSWORD")
    }
}
````

Make sure to exclude keystore.jks from version control by adding it to .gitignore.

---

🔐 Security notice
Do NOT commit your .jks file or any passwords to the repository.

Every developer should generate their own local keystore when building the app.

For CI/CD environments, use encrypted GitHub secrets to manage credentials safely.