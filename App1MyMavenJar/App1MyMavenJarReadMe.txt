Continuous Integration
	* Project structure / Management
	* Quickstart Example
	* POM (Dependency, compiler, DeistributionManagement)
	* Managing build versions while deploying to Artifactory


	* Unit Testing - Junit Framework - assert methods
	* Compiler configuration
	* Artifactory - Jfrog
		- Deploy using maven configuration (DistributionManagement & Settings.xml)
		- Deploy using Jenkins configuration ( Jfrog serice setup) 
	
1. create project from command line using below statement ( Quickstart=Jar Example; webapp=War Example)
	mvn archetype:generate 
	-DgroupId=<Module> 
	-DartifactId=<Project> 
	-DarchetypeArtifactId=maven-archetype-quickstart 
	-DinteractiveMode=false
	
2. Understand plugin, goal, structure & pom

3. Execute various goals and understand their responses
	Note: 	(1) To run your java application (.class file)
			Example:	java -classpath "target/classes" <package>.<ClassName>
			** java -classpath "target/classes" devops.maven.App
			
			(2) To run your java application (jar file)			
			java -cp <yourPath>/yourPackage.jar com.somepackage.yourMainClass
			Example:	java -cp D:\MyWorkspace\quickdemo\target\quickdemo-0.0.1-SNAPSHOT.jar com.base.quickdemo.App
			** java -cp "target/App1MyMavenJar-1.0-SNAPSHOT.jar" devops.maven.App
			
			(3) Configuring manifest details within pom - To run your java application (jar file)
				update pom with
				<build>
				<plugins>
					<plugin>
						<!-- Build an executable JAR -->
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-jar-plugin</artifactId>
						<version>2.4</version>
						<configuration>
							<archive>
								<manifest>
									<mainClass>com.base.quickdemo.App</mainClass>
								</manifest>
							</archive>
						</configuration>
					</plugin>
				<plugins>
				</build>

	===>execute >java -jar D:\MyWorkspace\quickdemo\target\quickdemo-0.0.1-SNAPSHOT.
	** java -jar target\App1MyMavenJar-1.0-SNAPSHOT.jar

4. Using deploy => Artifactory => Distribution Management => Jfrog Configuration

	Step1:Define Artifactory server with user credentials within maven settings.xml	
			<server>
			  <username>ArtifactoryUser</username>
			  <password>ArtifactoryUserPassword</password>
			  <id>central</id>
			</server> 
	Step2: Get Ditribution Management details from Artifactory
		ArtifactoryLogin > Artifacts > libs-release (for maven artifacts )..select set me up
		- copy distributionManagement details and paste within pom.xml (sample code given below)
			<distributionManagement>
				<repository>
					<id>central</id>
					<name>L-156072096-releases</name>
					<url>http://localhost:8040/artifactory/libs-release</url>
				</repository>
			</distributionManagement>
	Step3:Get settings.xml from Artifactory 	
		- Obtain / Generate settings.xml (From Jfrog), place within ~\.m2 folder.
		Note: you may replace encrypted password with actual password.
	

			
	Step4: Run maven goal with deploy
	
5. Configure Artifactory within Jenkins
	Step1: Install Artifactory plugin and configure Artifactory with url
		Note: If required bypass proxy under Advanced tab
	Step2: Under Post Build Acticions select "Deploy artifact to Artifactory"
	Step3: Select refresh ( select deployment strategy - either snapshot/release-local)
		- If Version suffix is SNAPSHOT then select snapshot only
	Step4: Enable override credentials and give Artifcatory credetials (devops/devops)
	
	
		(optional) : use build number to deploy
		include ${build.number} within version
		mvn deploy -Dbuild.number=<number>

####### Tips & techniqus ###########
	1 Transforming to Eclipse IDE project
		execute, mvn eclipse:eclipse <optional Version>
		*** mvn eclipse:eclipse -Dwtpversion=2.0
		Note: This option -Dwtpversion=2.0 tells Maven to convert the project into an Eclipse web project (WAR), 
		not the default Java project (JAR).For convenience, later we will show you how to configure this WTP option in pom.xml.
	
	2 Using Build Number
		a. include build number to version, in turn to artifact using ${build.number}
		b. Pass build number using argument -Dbuild.number=<number>	
		 <version>1.0.0-SNAPSHOT-${build.number}</version> 
		 <name>${project.artifactId}</name>
	 
	3. Configuring alternative compiler
		<properties>
			<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		  	<jdk.version>1.7</jdk.version>
		     <maven.compiler.source>1.6</maven.compiler.source>
	   	 	<maven.compiler.target>1.6</maven.compiler.target>
		</properties>
	
		<build>
			<plugins>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>2.3.2</version>
					<configuration>
						<source>${jdk.version}</source>
						<target>${jdk.version}</target>
						<encoding>${project.build.sourceEncoding}</encoding>
					</configuration>
				</plugin>
			</plugins>
		</build>
	
		Alternatively
		
		<build>
			<pluginManagement>
				<plugins>
					<plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-compiler-plugin</artifactId>
						<version>3.5.1</version>
						<configuration>
							<source>1.8</source>
							<target>1.8</target>
						</configuration>
					</plugin>
				</plugins>
			</pluginManagement>
		</build>
		
		4. ** configure / change local repo path **
			MAVEN_HOME settings.xml =>  <localRepository>/path/to/local/repo</localRepository>
			If this to reflect on eclipse .. you have to reset/re-apply