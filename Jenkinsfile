pipeline {
    agent any

    tools {
        jdk 'jdk-21.0.10'
        maven 'apache-maven-3.8.2'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/Abdulsalique/store-automation-framework.git'
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