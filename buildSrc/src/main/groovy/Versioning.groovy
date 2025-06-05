class Versioning {

    static String getGitTag() {
        def stdout = new ByteArrayOutputStream()
        try {
            def result = ['git', 'describe', '--tags', '--abbrev=0'].execute()
            result.consumeProcessOutput(stdout, System.err)
            result.waitFor()
            return stdout.toString().trim()
        } catch (Exception e) {
            return "v0.0.1"
        }
    }

    static String getVersionName() {
        return getGitTag().replace("v", "")
    }

    static int getVersionCode() {
        def version = getVersionName()
        def (major, minor, patch) = version.tokenize('.').collect { it.toInteger() }
        return major * 10000 + minor * 100 + patch
    }
}