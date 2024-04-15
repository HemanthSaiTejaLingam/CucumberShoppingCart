#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@testlogin
Feature: Registered user logins to the TestMe App

Background: Joe is a registered user on TestMe App

Scenario: Joe successfully logins to the TestMe App when he enters his credentials
				Given Joe is on log in page of TestMe App
				When Joe enter his credentials
				And clicks on login
				Then Joe logins Successfully to the TestMe App
