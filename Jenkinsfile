pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'MAVEN3'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Abdulsalique/store-automation-framework.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}