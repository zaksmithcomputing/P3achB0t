package com.p3achb0t.api.interfaces

interface Component : Node {
    fun getButtonText(): String
    fun getButtonType(): Int
    fun getChildIndex(): Int
    fun getChildren(): Array<Component>
    fun getClickMask(): Int
    fun getClientCode(): Int
    fun getColor(): Int
    fun getColor2(): Int
    fun getCs1ComparisonValues(): IntArray
    fun getCs1Comparisons(): IntArray
    fun getCs1Instructions(): Array<IntArray>
    fun getCycle(): Int
    fun getDragDeadTime(): Int
    fun getDragDeadZone(): Int
    fun getFill(): Boolean
    fun getFontId(): Int
    fun getHasListener(): Boolean
    fun getHeight(): Int
    fun getHeightAlignment(): Int
    fun getId(): Int
    fun getInvTransmitTriggers(): IntArray
    fun getInventorySprites(): IntArray
    fun getInventoryXOffsets(): IntArray
    fun getInventoryYOffsets(): IntArray
    fun getIsDraggable(): Boolean
    fun getIsHidden(): Boolean
    fun getIsIf3(): Boolean
    fun getItemActions(): Array<String>
    fun getItemId(): Int
    fun getItemIds(): IntArray
    fun getItemQuantities(): IntArray
    fun getItemQuantity(): Int
    fun getLineWid(): Int
    fun getModelAngleX(): Int
    fun getModelAngleY(): Int
    fun getModelAngleZ(): Int
    fun getModelFrame(): Int
    fun getModelFrameCycle(): Int
    fun getModelId(): Int
    fun getModelId2(): Int
    fun getModelOffsetX(): Int
    fun getModelOffsetY(): Int
    fun getModelOrthog(): Boolean
    fun getModelTransparency(): Boolean
    fun getModelType(): Int
    fun getModelType2(): Int
    fun getModelZoom(): Int
    fun getMouseOverColor(): Int
    fun getMouseOverColor2(): Int
    fun getMouseOverRedirect(): Int
    fun getNoClickThrough(): Boolean
    fun getOnChatTransmit(): Any
    fun getOnClanTransmit(): Any
    fun getOnClick(): Any
    fun getOnClickRepeat(): Any
    fun getOnDialogAbort(): Any
    fun getOnDrag(): Any
    fun getOnDragComplete(): Any
    fun getOnFriendTransmit(): Any
    fun getOnHold(): Any
    fun getOnInvTransmit(): Any
    fun getOnKey(): Any
    fun getOnLoad(): Any
    fun getOnMiscTransmit(): Any
    fun getOnMouseLeave(): Any
    fun getOnMouseOver(): Any
    fun getOnMouseRepeat(): Any
    fun getOnOp(): Any
    fun getOnRelease(): Any
    fun getOnScrollWheel(): Any
    fun getOnStatTransmit(): Any
    fun getOnStockTransmit(): Any
    fun getOnSubChange(): Any
    fun getOnTargetEnter(): Any
    fun getOnTargetLeave(): Any
    fun getOnTimer(): Any
    fun getOnVarTransmit(): Any
    fun getOpbase(): String
    fun getOps(): Array<String>
    fun getOutline(): Int
    fun getPaddingX(): Int
    fun getPaddingY(): Int
    fun getParent(): Component
    fun getParentId(): Int
    fun getRawHeight(): Int
    fun getRawWidth(): Int
    fun getRawX(): Int
    fun getRawY(): Int
    fun getRectangleMode(): RectangleMode
    fun getRootIndex(): Int
    fun getScrollHeight(): Int
    fun getScrollWidth(): Int
    fun getScrollX(): Int
    fun getScrollY(): Int
    fun getSequenceId(): Int
    fun getSequenceId2(): Int
    fun getSpellName(): String
    fun getSpriteAngle(): Int
    fun getSpriteFlipH(): Boolean
    fun getSpriteFlipV(): Boolean
    fun getSpriteId(): Int
    fun getSpriteId2(): Int
    fun getSpriteShadow(): Int
    fun getSpriteTiling(): Boolean
    fun getStatTransmitTriggers(): IntArray
    fun getTargetVerb(): String
    fun getText(): String
    fun getText2(): String
    fun getTextLineHeight(): Int
    fun getTextShadowed(): Boolean
    fun getTextXAlignment(): Int
    fun getTextYAlignment(): Int
    fun getTransparency(): Int
    fun getType(): Int
    fun getVarTransmitTriggers(): IntArray
    fun getWidth(): Int
    fun getWidthAlignment(): Int
    fun getX(): Int
    fun getXAlignment(): Int
    fun getY(): Int
    fun getYAlignment(): Int
    fun get__bh(): Boolean
    fun get__cu(): Boolean
    fun get__ea(): Boolean
    fun get__fi(): Boolean
    fun get__fp(): Boolean
    fun get__fw(): Boolean
    fun get__cb(): Array<ByteArray>
    fun get__cv(): Array<ByteArray>
    fun get__ah(): Int
    fun get__as(): Int
    fun get__ax(): Int
    fun get__bm(): Int
    fun get__bx(): Int
    fun get__bz(): Int
    fun get__fe(): Int
    fun get__ff(): Int
    fun get__fo(): Int
    fun get__fy(): Int
    fun get__cj(): IntArray
    fun get__cy(): IntArray
    fun get__fv(): IntArray
    fun get__eh(): Any
    fun get__el(): Any
    fun get__et(): Any
    fun get__eu(): Any
}
