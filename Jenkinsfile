pipeline {

   agent any

   stages {
      stage('Run Gatling stress test') {
         steps {
            sh 'export GATLING_USERS=50'
            sh './gradlew gatlingRun'
         }
      }
   }
}
