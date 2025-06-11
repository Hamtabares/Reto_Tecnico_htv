Feature: Reserva de cita seleccionando una fecha en el calendario

  Background:
  Given que abro la pagina principal de JQuery Datepicker

  @id1
  Scenario: Selección del día 15 del mes actual
    When hago clic en el campo de selección de fecha
    Then la fecha seleccionada debe aparecer en el campo de texto "06/15/2025"

  @id2
  Scenario: Selección del día 10 del próximo mes
    And navego hasta el proximo mes
    Then la fecha seleccionada debe aparecer en el campo de texto "07/10/2025"

  @id3
  Scenario: Intento de edición manual del campo de fecha bloqueado
    When intento ingresar una fecha manualmente en el campo de texto "06/20/2025"
    Then no se debe permitir la edición manual
