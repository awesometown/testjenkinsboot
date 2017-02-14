node {
    checkout scm
    stage('Compile') {
        sh "./gradlew clean assemble -PBUILD_NUMBER=${env.BUILD_NUMBER}"
    }
    stage('Build Image') {
        sh "./gradlew buildImage -PBUILD_NUMBER=${env.BUILD_NUMBER}"
    }
}