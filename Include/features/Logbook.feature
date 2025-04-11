@logbook
Feature: logbook
  As a user, I want to add logbook

  @Logbook001
  Scenario: Logbook001 - User want to add logbook
    Given The User go to login page
    Then User login with valid credentials
    And User click button tambah logbook
    Then User input date "20112025"
    Then User select 8 am jam mulai
    And User Select 8 pm jam selesai
    Then User select WFO on field mode kerja
    And User input "HRSV2" on field Project
    Then User input "Alpha" on field Nama Tim
    Then User input "logbook1" on field Use Case
    Then User select Belajar Materi on field Kegiatan
    Then User input "2" on field hasil
    Then User input "80" on field Capaian
    Then User select continue on field Next Step
    Then User input "Katalon" on field Path/Filename
    Then User input "Automation" on field Detail pekerjaan
    Then User select Jam lembur on field Waktu Kerja
    And User click button Submit
    Then popup Success appear
    Then User click button ok
    
  @Logbook002
  Scenario: Logbook002 - User wants to add a logbook without filling in the field
    And User click button tambah logbook
    Then User click button Submit
    
  @Logbook003
  Scenario: Logbook003 - User wants to delete logbook
    And User click button cancel
    Then User click icon delete
    Then User click button OK
    
  
