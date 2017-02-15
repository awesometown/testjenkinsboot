node {
    checkout scm

    stage('Compile') {

        withCredentials([[$class          : 'UsernamePasswordMultiBinding', credentialsId: 'AWS',
                          usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
            sh '''
            set +x
            echo $USERNAME
            echo $PASSWORD
            set AWS_ACCESS_KEY_ID=$USERNAME
            set AWS_SECRET_ACCESS_KEY=$PASSWORD
            ./gradlew clean assemble -PBUILD_NUMBER=$BUILD_NUMBER -Daws.accessKeyId=$USERNAME -Daws.secretKey=$PASSWORD
           '''
        }
    }
    stage('Build Image') {
        sh "./gradlew buildImage -PBUILD_NUMBER=${env.BUILD_NUMBER} -PAWS_ACCESS_KEY_ID=$USERNAME -PAWS_SECRET_ACCESS_KEY=$PASSWORD"
    }
}