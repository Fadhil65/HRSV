@pengajuan_cuti
Feature: cuti
  As a user, I want to apply for leave

  @cuti001
  Scenario: Ajukan cuti beberapa kali dengan pengecekan validasi
    Given The User go to login page
    Then User login with valid credentials
    Then User click menu Cuti dan Lembur
    When User click menu Pengajuan Cuti
    Then User click button Ajukan Cuti
    When User filling form ajukan cuti sebanyak 2 kali
    