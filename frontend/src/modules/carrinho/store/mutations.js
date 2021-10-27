import * as types from "./mutation-types";

export default {
  [types.ADD_ITEM](state, item) {
    item.qtd = 1 ;
    state.items.push(item);
  },

  [types.QTD_ITEM](state, item) {
    var i = state.items.filter(item => item.id == item.id);
    state.items = state.items.filter(item => item.id !== item.id);
   
    if(i.qtd>item.qtd){
      item.qtd--;
    }else{
      item.qtd++;
    }

    state.items.push(item);
  },

  [types.REMOVE_ITEM](state, id) {
    state.items = state.items.filter(item => item.id !== id);
  }
};
