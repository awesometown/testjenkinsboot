node {
    withCredentials([[$class          : 'UsernamePasswordMultiBinding', credentialsId: 'AWS',
                      usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
        checkout scm

        stage('Compile') {
            sh "./gradlew clean assemble -PBUILD_NUMBER=${env.BUILD_NUMBER} -Daws.accessKeyId=${env.USERNAME} -Daws.secretKey=${env.PASSWORD}"
        }

        stage('Build Image') {
            sh "./gradlew buildImage -PBUILD_NUMBER=${env.BUILD_NUMBER} -Daws.accessKeyId=${env.USERNAME} -Daws.secretKey=${env.PASSWORD}"
        }
    }
}

def promote = false

stage ("Deploy Check") {
    try {
        timeout(time: 30, unit: 'SECONDS') {
            promote = input message: 'Deploy to AWS?', parameters: [booleanParam(defaultValue: true, description: '', name: 'proceed')]
        }
    } catch (err) {
        //this is ok; just means we timed out waiting for someone to promote
    }
}

if(promote) {
    node {
        stage('Deploy Image') {
            sh "./gradlew publishImage -PBUILD_NUMBER=${env.BUILD_NUMBER} -Daws.accessKeyId=${env.USERNAME} -Daws.secretKey=${env.PASSWORD}"
        }
    }
}
