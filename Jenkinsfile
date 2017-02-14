node {
    checkout scm
    stage('Compile') {
        sh "./gradlew clean -PBUILD_NUMBER=${env.BUILD_NUMBER}"
    }
}