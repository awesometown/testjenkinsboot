node {
    checkout scm
    stage('Compile') {
        sh "./gradlew clean build -PBUILD_NUMBER=${env.BUILD_NUMBER}"
    }
    stage('Build Image') {
        sh "./gradlew buildImage -PBUILD_NUMBER=${env.BUILD_NUMBER}"
    }
}