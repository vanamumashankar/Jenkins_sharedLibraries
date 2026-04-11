def call(String filename, String toolname){
  sh """
  dependencyCheck additionalArguments: '--scan ./', odcInstallation: '${toolname}'
dependencyCheckPublisher pattern: '**/${filename}-report.xml'
"""
}
