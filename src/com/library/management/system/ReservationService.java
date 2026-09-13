package com.library.management.system;

public class ReservationService {

   private NotificationManager notificationManager;

   public ReservationService(NotificationManager notificationManager) {
      this.notificationManager = notificationManager;
   }

   public Reservation reserve(Book book, Patron patron) {
      Reservation reservation = new Reservation(book, patron);

      notificationManager.addObserver(book, patron);

      return reservation;
   }
}
