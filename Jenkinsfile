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

//        stage('Deploy Image') {
//            sh "./gradlew publishImage -PBUILD_NUMBER=${env.BUILD_NUMBER} -Daws.accessKeyId=${env.USERNAME} -Daws.secretKey=${env.PASSWORD}"
//        }
    }
}

stage 'promotion'
def userInput = input(
        id: 'userInput', message: 'Let\'s promote?', parameters: [
        [$class: 'TextParameterDefinition', defaultValue: 'uat', description: 'Environment', name: 'env']
])
echo ("Env: "+userInput)