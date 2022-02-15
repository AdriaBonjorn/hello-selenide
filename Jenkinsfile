pipeline {
    agent any

    stages {

        stage('Test'){
            steps {
                     sh "./gradlew clean test pitest"
                        }
                        post {
                            // If Gradle was able to run the tests, even if some of the test
                            // failed, record the test results and archive the jar file.
                            always {
                                junit 'build/test-results/test/*.xml'
                                jacoco execPattern: 'build/jacoco/*.exec'

                            }
                        }
        }
        stage('Build') {
            steps {

                // Run Gradle Wraper baby
                sh "./gradlew assemble"
            }
            post {
                // If Gradle was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                         archiveArtifacts 'build/libs/*.jar'
                }
            }
        }
        stage('Deploy'){
            steps{
                    echo 'Deploying...'
            }
        }
    }
}