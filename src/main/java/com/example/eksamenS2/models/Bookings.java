package com.example.eksamenS2.models;

import java.sql.SQLData;

public class Bookings {

        private SQLData FromDate, EndDate;

        public Bookings(SQLData fromDate, SQLData endDate) {
                FromDate = fromDate;
                EndDate = endDate;
        }


        public SQLData getFromDate() {
                return FromDate;
        }

        public void setFromDate(SQLData fromDate) {
                FromDate = fromDate;
        }

        public SQLData getEndDate() {
                return EndDate;
        }

        public void setEndDate(SQLData endDate) {
                EndDate = endDate;
        }
}
