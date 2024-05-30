package com.saaws88.chinacalc.domain.model.order.enumerated;

/**
 * Статус заказа
 */
public enum OrderStatus {
  /**
   * Заказ создан
   */
  CREATED,
  /**
   * Заказ оплачен
   */
  PAYED,
  /**
   * Заказ отправлен на сортер в Иу
   */
  SENT_TO_YIWU,
  /**
   * Заказ прибыл на сортер в Иу
   */
  DELIVERED_TO_YIWU,
  /**
   * Заказ отправлен в Россию
   */
  SENT_TO_RUSSIA,
  /**
   * Заказ доставлен в Россию
   */
  DELIVERED_TO_RUSSIA,
  /**
   * Заказ получен
   */
  RECEIVED,
  /**
   * Заказ отменен
   */
  CANCELED
}
