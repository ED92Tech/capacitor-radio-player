import { WebPlugin } from '@capacitor/core';
import { RadioPlayerPlugin } from './definitions';

export class RadioPlayerWeb extends WebPlugin implements RadioPlayerPlugin {
  constructor() {
    super({
      name: 'RadioPlayer',
      platforms: ['web']
    });
  }

  async echo(options: { value: string }): Promise<{value: string}> {
    console.log('ECHO', options);
    return options;
  }
}

const RadioPlayer = new RadioPlayerWeb();

export { RadioPlayer };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(RadioPlayer);
