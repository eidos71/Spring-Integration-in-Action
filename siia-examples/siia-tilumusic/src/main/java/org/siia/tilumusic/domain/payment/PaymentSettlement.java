package org.siia.tilumusic.domain.payment;


public abstract class PaymentSettlement
{
   private FinancialAmount amount;

   public FinancialAmount getAmount()
   {
      return amount;
   }

   public void setAmount(FinancialAmount amount)
   {
      this.amount = amount;
   }
   
}