pipeline {

    agent any

    parameters {

        choice(
            name: 'ENVIRONMENT',
            choices: ['qa', 'dev', 'prod'],
            description: 'Select the environment for test execution'
        )

        choice(
            name: 'BROWSER',
            choices: ['chrome', 'edge'],
            description: 'Select browser'
        )

        booleanParam(
            name: 'HEADLESS',
            defaultValue: false,
            description: 'Run browser in headless mode'
        )
    }

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    stages {

        stage('Checkout') {

            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Clean') {

            steps {
                echo 'Cleaning previous build...'
                bat 'mvn clean'
            }
        }

        stage('Run Tests') {

            steps {

                echo "Environment: ${params.ENVIRONMENT}"
                echo "Browser: ${params.BROWSER}"
                echo "Headless: ${params.HEADLESS}"

                bat """
                    mvn test ^
                    -Denvironment=${params.ENVIRONMENT} ^
                    -Dbrowser=${params.BROWSER} ^
                    -Dheadless=${params.HEADLESS}
                """
            }
        }
    }

    post {

        always {

            echo 'Test execution completed.'

            archiveArtifacts artifacts:
                'test-output/**/*, logs/**/*, screenshots/**/*',
                allowEmptyArchive: true
        }

        success {

            echo 'Automation tests passed successfully.'
        }

        failure {

            echo 'Automation tests failed.'
        }
    }
}