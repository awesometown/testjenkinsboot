node {
    withCredentials([[$class          : 'UsernamePasswordMultiBinding', credentialsId: 'AWS',
                      usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
        checkout scm

        stage('Compile') {

                sh "./gradlew clean assemble -PBUILD_NUMBER=${env.BUILD_NUMBER} -Daws.accessKeyId=${env.USERNAME} -Daws.secretKey=${env.PASSWORD}"
            }

            stage('Build Image') {
                sh "./gradlew buildImage -PBUILD_NUMBER=${env.BUILD_NUMBER} -PAWS_ACCESS_KEY_ID=${env.USERNAME} -PAWS_SECRET_ACCESS_KEY=${env.PASSWORD}"
            }
        }
    }
}