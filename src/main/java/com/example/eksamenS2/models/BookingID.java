package com.example.eksamenS2.models;


public class BookingID {

        private java.sql.Date FromDate, EndDate;
        private String StaffID;
        private int CustomerID, BookingID;

        public BookingID() {
        }

        public BookingID(java.sql.Date fromDate, java.sql.Date endDate, String staffID, int customerID, int bookingID) {
                FromDate = fromDate;
                EndDate = endDate;
                StaffID = staffID;
                CustomerID = customerID;
                BookingID = bookingID;

        }

        public String getStaffID() {
                return StaffID;
        }

        public void setStaffID(String staffID) {
                StaffID = staffID;
        }

        public int getCustomerID() {
                return CustomerID;
        }

        public void setCustomerID(int customerID) {
                CustomerID = customerID;
        }

        public java.sql.Date getFromDate() {
                return FromDate;
        }

        public void setFromDate(java.sql.Date fromDate) {
                FromDate = fromDate;
        }

        public java.sql.Date getEndDate() {
                return EndDate;
        }

        public void setEndDate(java.sql.Date endDate) {
                EndDate = endDate;
        }

        public int getBookingID() {
                return BookingID;
        }

        public void setBookingID(int bookingID) {
                BookingID = bookingID;
        }
}
